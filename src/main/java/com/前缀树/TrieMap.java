package com.前缀树;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author Lin Yizhou
 * @Date 2023/3/15 12:45
 */


public class TrieMap<V> {
    public static void main(String[] args) {

    }
    //未写完整

    public TrieMap() {
        root = new TrieNode<>();
    }

    private static final int R = 256;
    private int size = 0;

    private static class TrieNode<V> {
        V val = null;
        TrieNode<V>[] children = new TrieNode[R];
    }

    private TrieNode<V> root = null;

    public int size() {
        return size;
    }

    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
        for (int i = 0; i < key.length(); i++) {
            if (p == null) return null;
            char c = key.charAt(i);
            p = p.children[c];
        }
        return null;

    }

    public V get(String key) {
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) return null;
        return x.val;
    }

    public boolean containsKey(String key) {
        return get(key) != null;
    }

    //想法不一样
    public String shortestPrefixOf(String query) {
        TrieNode<V> p = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < query.length(); i++) {
            p = p.children[query.charAt(i)];
            sb.append(query.charAt(i));
            if (p == null || p.val != null) break;
        }
        if (p != null && p.val == null) return query;
        return sb.toString();

    }

    public String longestPrefixOf(String query) {
        int max = 0;
        TrieNode<V> p = root;

        for (int i = 0; i < query.length(); i++) {
            p = p.children[query.charAt(i)];
            if (p.val != null) {
                max = i;
            }
        }
        if (p != null && p.val == null) return query;
        return query.substring(0, max + 1);
    }


}
