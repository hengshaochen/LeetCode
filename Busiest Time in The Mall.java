  static int findBusiestPeriod(int[][] data) {
    if (data.length == 0) { return 0; }
    int max = Integer.MIN_VALUE;
    int tag = data[0][0];
    int cur_val = 0;
    
    for (int i = 0; i < data.length; i++) {
      if (data[i][2] == 1)
        cur_val += data[i][1];
      else 
        cur_val -= data[i][1];
      
      if (i < data.length - 1 && data[i][0] == data[i + 1][0]) {
        continue;
      } 
      if (cur_val > max) {
        max = cur_val;
        tag = data[i][0];
      }
    }
    return tag;
  }

// my version
    static int findBusiestPeriod(int[][] data) {
    if (data.length == 0) { return 0; }
    int max = Integer.MIN_VALUE;
    int tag = data[0][0];
    int cur_val = 0;
    
    for (int i = 0; i < data.length; i++) {
      if (data[i][2] == 1)
        cur_val += data[i][1];
      else 
        cur_val -= data[i][1];
      
      if (i == data.length - 1 || data[i][0] != data[i + 1][0]) {

        if (cur_val > max) {
          max = cur_val;
          tag = data[i][0];
        }
      }
      
    }
    return tag;
  }