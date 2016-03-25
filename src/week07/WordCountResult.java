package week07;

public class WordCountResult {
    private final int mWordCount;
    private final int mLineCount;
    private final int mCharacterCount;

    public WordCountResult(int wordCount, int lineCount, int characterCount) {
        mWordCount = wordCount;
        mLineCount = lineCount;
        mCharacterCount = characterCount;
    }

    public int getWordCount() {
        return mWordCount;
    }

    public int getLineCount() {
        return mLineCount;
    }

    public int getCharacterCount() {
        return mCharacterCount;
    }
}