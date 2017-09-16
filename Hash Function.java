class Solution {
    public int hashCode(char[] key,int HASH_SIZE) {
        // (abc)=(33(33(33×0+a)+b)+c)%M， 
        // 再根据(a×b)%M=((a%M)×(b%M))%M
        // 以防止overflow
        long ans = 0;
        for(int i = 0; i < key.length;i++) {
            ans = (ans * 33 + (int)(key[i])) % HASH_SIZE; 
        }
    return (int)ans;
    }
};
