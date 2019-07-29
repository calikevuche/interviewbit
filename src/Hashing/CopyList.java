package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class CopyList {

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();

        RandomListNode cur = head, random = null;
        RandomListNode copyCur = null, copyHead = null, copyPrev = null, copyRand = null;

        while (cur != null) {

            if (hashMap.containsKey(cur)) {
                copyCur = hashMap.get(cur);
            } else {
                copyCur = new RandomListNode(cur.label);
                hashMap.put(cur, copyCur);
            }

            if (copyHead == null) {
                copyHead = copyCur;
            }
            if (copyPrev != null) {
                copyPrev.next = copyCur;
            }

            random = cur.random;
            if (random != null) {
                if (hashMap.containsKey(random)) {
                    copyRand = hashMap.get(random);
                } else {
                    copyRand = new RandomListNode(random.label);
                    hashMap.put(random, copyRand);
                }
                copyCur.random = copyRand;
            }

            copyPrev = copyCur;
            cur = cur.next;
        }

        return copyHead;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {

        RandomListNode cur = head, next = head;
        RandomListNode copyCur = null, copyHead = null, copyNext = null;

        while (cur != null) {
            copyCur = new RandomListNode(cur.label);
            next = cur.next;
            cur.next = copyCur;
            copyCur.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            copyCur = cur.next;
            if (cur.random != null) {
                copyCur.random = cur.random.next;
            } else {
                copyCur.random = null;
            }
            cur = cur.next.next;
        }

        cur = head;
        copyCur = head.next;
        copyHead = head.next;
        while (copyCur != null && cur != null) {
            cur.next = cur.next.next;
            if (copyCur.next == null) {
                break;
            }
            copyCur.next = copyCur.next.next;
            copyCur = copyCur.next;
            cur = cur.next;
        }

        return copyHead;
    }
}
