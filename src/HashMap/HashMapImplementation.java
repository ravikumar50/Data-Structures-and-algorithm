package HashMap;

import Queue.LimkedListmplemationOfCircularQueue;

import java.util.LinkedList;
import java.util.Scanner;



public class HashMapImplementation {
               public static class hashMap<K,V>{
            static final int DEFAULT_CAPACITY = 4;
            static final float DEFAULT_LOAD_FACTOR = 0.75f;
            private  int size=0;
            private class Node{
                K key;
                V value;

                Node(K key, V value){
                   this.key=key;
                   this.value=value;
                }
            }

            private LinkedList<Node> bucket[];

            private void initbuckets(int n){
                bucket = new LinkedList[n];

                for(int i=0; i<n; i++){
                    bucket[i] = new LinkedList<>();
                }
            }
            public hashMap(){
                 initbuckets(DEFAULT_CAPACITY);
            }

            private int hashFunction(K key){
                int hc = key.hashCode();
                int idx = Math.abs(hc)% bucket.length;
                return idx;
            }

            private int searchIndex(LinkedList<Node> ll, K key){

                for(int i=0; i<ll.size(); i++){
                    if(ll.get(i).key==key){
                        return i;
                    }
                }
                return -1;
            }

            private void rehash(){
                LinkedList<Node>[] oldBucket = bucket;
                initbuckets(oldBucket.length*2);
                size=0;
                for(var buckets : oldBucket){
                    for(var node : buckets){
                        put(node.key,node.value);
                    }
                }
            }


            void put(K key, V val){
                int bi = hashFunction(key);
                LinkedList<Node> currBucket = bucket[bi];

                int idx = searchIndex(currBucket,key);

                if(idx==-1){
                    Node t = new Node(key,val);
                    currBucket.add(t);
                }else{
                    currBucket.get(idx).value=val;
                }
                size++;

                // rehashing

                if(size>= bucket.length*DEFAULT_LOAD_FACTOR){
                    rehash();
                }
            }

            void putIfAbsent(K key, V val){
                int bi = hashFunction(key);
                LinkedList<Node> currBucket = bucket[bi];
                int idx = searchIndex(currBucket,key);

                if(idx==-1){
                    Node t = new Node(key, val);
                    currBucket.add(t);
                    size++;
                }

            }

            V get(K key){
               int bi = hashFunction(key);
               LinkedList<Node> currBucket = bucket[bi];
               int idx = searchIndex(currBucket,key);

               if(idx==-1) return null;
               else{
                   return currBucket.get(idx).value;
               }
            }

            V remove(K key) {
                int bi = hashFunction(key);
                LinkedList<Node> currBucket = bucket[bi];
                int idx = searchIndex(currBucket, key);

                if (idx == -1) {
                    return null;
                } else {
                    V value = currBucket.get(idx).value;
                    currBucket.remove(idx);
                    size--;
                    return value;
                }
            }

            boolean containsKey(K key){
                int bi = hashFunction(key);
                LinkedList<Node> currBucket = bucket[bi];
                int idx = searchIndex(currBucket,key);

                if(idx==-1) return false;
                else return true;
            }

            void keySet(){
                for(int i=0; i<bucket.length; i++){
                    for(int j=0; j<bucket[i].size(); j++){
                        System.out.print(bucket[i].get(j).key+" ");
                    }
                }
                System.out.println();
            }

            void values(){
                for(int i=0; i<bucket.length; i++){
                    for(int j=0; j<bucket[i].size(); j++){
                        System.out.print(bucket[i].get(j).value+" ");
                    }
                }
                System.out.println();
            }

            void entrySet(){
                for(int i=0; i<bucket.length; i++){
                    for(int j=0; j<bucket[i].size(); j++){
                        System.out.print(bucket[i].get(j).key+" = "+bucket[i].get(j).value+" , ");
                    }
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            hashMap<String, Integer> hp = new hashMap<>();

            String s = "Shubham";
            int a = 3289;
            hp.put(s,a);
            hp.put("Ravi" , 22088726);
            hp.put("Rishav", 22829);
            hp.put("Rohit", 402249);
            hp.put("Tez", 402249);
            hp.put("Ramu", 402249);
            hp.put("Raj", 402249);
            System.out.println(hp);
//            System.out.println(hp.size);
//
//            hp.entrySet();
//            System.out.println(hp.bucket.length);








        }
    }

