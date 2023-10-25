package Hw3_21000663_NguyenNgocAnh.Exercise04;

public class WordCount implements Comparable<WordCount> {
    
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() { 
        return word; 
    }

    public int getCount() { 
        return count; 
    }

    public void setWord(String word) { 
        this.word = word; 
    }

    public void setCount(int count) { 
        this.count = count; 
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return word.equals(((WordCount)o).getWord());
    }

    @Override
    public int compareTo(WordCount o) {
        return word.compareTo(o.getWord());
    }

    @Override
    public String toString() {
        return "(" + word + " " + count + ")";
    }
}
