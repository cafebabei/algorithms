package com.none.algorithms.dfafilter.textUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensitiveWordsTreeCache {

    public static final String TREE_END_TAG = "end";

    private SensitiveWordsTreeCache() {
    }

    private static SensitiveWordsTreeCache treeCache;

    public static SensitiveWordsTreeCache getInstance() {
        if (null == treeCache) {
            synchronized (SensitiveWordsTreeCache.class) {
                if (null == treeCache) {
                    treeCache = new SensitiveWordsTreeCache();
                }
            }
        }
        return treeCache;
    }

    public Map<String, Map> generateTree(List<String> sensitiveWords) {
        Map<String, Map> wordsTree = new HashMap<>();
        if (sensitiveWords == null || sensitiveWords.isEmpty()) return wordsTree;
        wordsTree.clear();
        for (String sensitiveWord : sensitiveWords) {
            addSensitiveWordToTree(wordsTree, StringUtils.trimToEmpty(sensitiveWord));
        }
        return wordsTree;
    }

    private Map<String, Map> addSensitiveWordToTree(Map<String, Map> tree, String word) {
        if (StringUtils.isEmpty(word)) {
            tree.putAll(addEnd());
            return tree;
        }
        String next = word.substring(0, 1);
        Map<String, Map> childTree = tree.get(next);
        if (childTree == null) {
            childTree = new HashMap<>();
        }
        tree.put(next, addSensitiveWordToTree(childTree, word.substring(1)));
        return tree;
    }

    private Map<String, Map> addEnd() {
        Map<String, Map> endTag = new HashMap<>();
        endTag.put(TREE_END_TAG, Collections.EMPTY_MAP);
        return endTag;
    }


}
