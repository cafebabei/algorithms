package com.none.other.dfafilter.bean;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SensitiveWordDetectionResult implements Serializable {

    private static final long serialVersionUID = 6908376892848907410L;

    private String keyWord;

    private List<PositionNode> positions;

    public SensitiveWordDetectionResult(int startPosition, String word) {
        this.keyWord = word;
        positions = new ArrayList<>();
        positions.add(new PositionNode(startPosition, startPosition + word.length()));
    }

    public void addPosition(int startPosition, String word) {
        this.keyWord = word;
        positions.add(new PositionNode(startPosition, startPosition + word.length()));
    }

    @Data
    public class PositionNode {
        private int startPosition;
        private int endPosition;

        public PositionNode(int startPosition, int endPosition) {
            super();
            this.startPosition = startPosition;
            this.endPosition = endPosition;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((keyWord == null) ? 0 : keyWord.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SensitiveWordDetectionResult other = (SensitiveWordDetectionResult) obj;
        if (keyWord == null) {
            if (other.keyWord != null)
                return false;
        } else if (!keyWord.equals(other.keyWord))
            return false;
        return true;
    }
}
