class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Rutgers University - New Brunsiwck");
        list.add("University of Illinos");
        list.add("University of Chicago");
        list.add("Purdue University - West Lafayee");
        
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println((String) it.next());
        }
        
    }
}