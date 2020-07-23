package com.none.other.dfafilter.textUtil;

import com.none.other.dfafilter.bean.SensitiveWord;
import com.none.other.dfafilter.bean.SensitiveWordDetectionResult;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SensitiveWordDetectionUtil {

    public static final String TREE_END_TAG = "end";

    public static final Map<String, Map> wordsTree = SensitiveWordsTreeCache.getInstance().generateTree(null);

    private List<SensitiveWordDetectionResult> findWords(String text) {
        String preChar = null;
        int startPosition = 0;
        List<SensitiveWordDetectionResult> detectResults = new ArrayList<>();
        while (true) {
            try {
                if (wordsTree == null || wordsTree.isEmpty() || StringUtils.isEmpty(text)) {
                    return detectResults;
                }
                String currentChar = text.substring(0, 1);
                text = text.substring(1);
                Map<String, Map> nextWord = wordsTree.get(currentChar);
                if (nextWord == null) {
                    preChar = currentChar;
                    continue;
                }
                SensitiveWord sensitiveWord = getSensitiveWord(currentChar, nextWord, text);
                if (sensitiveWord == null) {
                    preChar = currentChar;
                    continue;
                }
                SensitiveWordDetectionResult result = new SensitiveWordDetectionResult(startPosition, sensitiveWord.getWord());
                int index = detectResults.indexOf(result);
                if (index > -1) {
                    detectResults.get(index).addPosition(startPosition, sensitiveWord.getWord());
                } else {
                    detectResults.add(result);
                }
                text = text.substring(sensitiveWord.getWord().length() - 1);
                preChar = sensitiveWord.getWord().substring(sensitiveWord.getWord().length() - 1);
                startPosition = startPosition + sensitiveWord.getWord().length() - preChar.length();
                continue;
            } finally {
                if (preChar != null) {
                    startPosition = startPosition + preChar.length();
                }
            }

        }
    }

    private SensitiveWord getSensitiveWord(String currentChar, Map<String, Map> nextWordsTree,
                                           String text) {
        Map<String, Object> endTag = nextWordsTree.get(TREE_END_TAG);
        if (StringUtils.isEmpty(text)) {
            if (endTag != null) return new SensitiveWord(currentChar);
            return null;
        }
        String nextChar = text.substring(0, 1);
        Map<String, Map> nextTree = nextWordsTree.get(nextChar);
        if (endTag == null) {
            if (nextTree != null && nextTree.size() > 0)
                return getSensitiveWord(currentChar + nextChar, nextTree, text.substring(1));
            return null;
        }
        if (nextTree != null && nextTree.size() > 0) {
            SensitiveWord sensitiveWord = getSensitiveWord(currentChar + nextChar, nextTree,
                    text.substring(1));
            if (sensitiveWord == null) sensitiveWord = new SensitiveWord(currentChar);
            return sensitiveWord;
        }
        return new SensitiveWord(currentChar);
    }

}
