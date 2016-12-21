package com.Toropova.servlet;
import java.util.*;


public class Index {
    //INSTANCE;
    private HashMap<String, HashSet<Integer>> invertedIndex = new HashMap<String, HashSet<Integer>>();;

    private Tokenizer tokenizer = new Tokenizer();

    public void loadDocument(int id, String document) {
        ArrayList<String> wordList = tokenizer.tokenizeDocument(document);
        for (int i = 0; i < wordList.size(); i++) {
            String token = wordList.get(i);
            if (!invertedIndex.containsKey(token)) {
                invertedIndex.put(token, new HashSet<Integer>());
            }
            if (!invertedIndex.get(token).contains(id)) {
                invertedIndex.get(token).add(id);
            }
        }
    }

    public Set<Integer> search(String keywords) {
        ArrayList<String> keywordList = tokenizer.tokenizeDocument(keywords);
        Set<Integer> documents = new HashSet<Integer>();

        for (int i = 0; i < keywordList.size(); i++) {
            String keyword = keywordList.get(i);
            if (invertedIndex.containsKey(keyword)) {
                if (documents.isEmpty()) {
                    documents = invertedIndex.get(keyword);
                } else {
                    documents.retainAll(invertedIndex.get(keyword));
                }
            }
        }
        return documents;
    }

    public void printIndex() {
        System.out.println(this.invertedIndex);
    }

    //public static Index getInstance() {
   //     return INSTANCE;
   // }


    public static void main(String[] args) {
        Index index = new Index();

    }

}