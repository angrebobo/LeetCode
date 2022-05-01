package 左神算法;

import java.util.HashMap;
import java.util.Random;

/**
 * 设计RandomPool结构,在该结构中有如下三个功能：
 * insert(key):将某个key加入到该结构，做到不重复加入
 * delete(key):将原本在结构中的某个key移除
 * getRandom():等概率随机返回结构中的任何一个key
 * 【要求】
 * Insert、delete和getRandom方法的时间复杂度都是O(1)
 */

/**
 * 思路：
 * 看到时间复杂度是O(1),想到HashMap
 * 定义两个HashMap，第一个Map存<Key, Index>，第二个Map存<Index, Key>.Key是存储的值，
 * Index是逻辑顺序
 * 插入操作：往Map中存储值，时间复杂度是O(1)
 * 随机取值操作：因为维护了一个逻辑位置，所以可以采用系统提供的Random函数来等概率获取
 *      到0-size值键的某一个值。系统提供的函数是概率平均的，而且我维护的逻辑位置也是连续的，
 *      那就能随机取值是等概率且时间复杂度为O(1)
 *  删除操作：删除操作有一些复杂，如果在逻辑顺序中间删掉一个值，那随机取值操作就不是等概率了。
 *          所以为了保证逻辑顺序的连续性，如果要删掉某个元素，把最后一个元素来替换要删掉的元素，
 *          并删掉最后一个元素，减小Map的size。这样就能保证我的逻辑顺序是连续的，存取操作时O(1)
 *
 */
public class RandomPool {

    public static class Pool<Key>{
        //HashMap<K, String>这里的K表示只要是同一种类型就OK了，但并没有指定是哪一种类型
        //例如我需要放String的类型，那第一个放进去的时候，K就被指定为String 了
        HashMap<Key, Integer>keyIndexMap;
        HashMap<Integer, Key>indexKeyMap;
        int size = 0;
        public Pool(){
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
        }
        //插入到pool
        public void insert(Key k){
            keyIndexMap.put(k, size);
            indexKeyMap.put(size, k);
            size++;
        }
        //删除
        public void delete(Key key){
            if(!keyIndexMap.containsKey(key)){
                return ;
            }
            int lastIndex = --size;
            int deleteIndex = keyIndexMap.get(key);
            Key lastKey = indexKeyMap.get(lastIndex);
            keyIndexMap.put(lastKey, deleteIndex);
            indexKeyMap.put(deleteIndex, lastKey);
            keyIndexMap.remove(key);
            indexKeyMap.remove(lastIndex);
        }
        //获取随机
        public Key getRandom(){
            if(size==0){
                return null;
            }
            Random random = new Random();
            //获取一个0到(size-1)的下标值
            int index = random.nextInt(size);
            return indexKeyMap.get(index);
        }
        //test
        public static void main(String[] args) {
            Pool<String> pool = new Pool<>();
            pool.insert("laoganma");
            pool.insert("nengandie");
            pool.insert("yyziii");
            pool.insert("aaaaaa");
            for (int i = 0; i < 10; i++) {
                System.out.println(pool.getRandom());
            }
            pool.delete("nengandie");
            System.out.println("=======");
            for (int i = 0; i < 10; i++) {
                System.out.println(pool.getRandom());
            }
        }
    }
}
