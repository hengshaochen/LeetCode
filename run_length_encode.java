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

class Main {
    public static void main(String[] args) {
        // GGGaaG->3G2a1G
        
        String a = "GGGaaG";
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            while (i != a.length() - 1 && a.charAt(i) == a.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(a.charAt(i));
            count = 1;
        }
        System.out.println(sb.toString());
    }
}