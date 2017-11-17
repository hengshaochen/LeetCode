class Main {
    public static void main(String[] args) {
        String input = "GGGaaG";
        int count = 1;
        
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            while (i != input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            output = output + count + input.charAt(i);
            count = 1;
        }
        System.out.println(output);
        
    }
}