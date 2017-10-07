/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // find root index
        Employee root = idToE(id, employees);
        
        // do BFS in the tree that root.val == id
        int total_importance = 0;
        Queue<Employee> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Employee cur = q.remove(); 
                total_importance += cur.importance;
                // 探訪cur的兒子(手下)
                for (int j = 0; j < cur.subordinates.size(); j++) {
                    q.add(idToE(cur.subordinates.get(j), employees));
                }
            }
            
        }
        return total_importance;
    }
    public Employee idToE(int id, List<Employee> employees) {
        Employee e = new Employee();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                e = employees.get(i);
            }
        }
        return e;
    }
}

// HashMap Version:
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // id to Employee
        HashMap<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        
        // find root index
        Employee root = map.get(id);
        
        // do BFS in the tree that root.val == id
        int total_importance = 0;
        Queue<Employee> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Employee cur = q.remove(); 
                total_importance += cur.importance;
                // 探訪cur的兒子(手下)
                for (int j = 0; j < cur.subordinates.size(); j++) {
                    q.add(map.get((cur.subordinates.get(j))));
                }
            }
            
        }
        return total_importance;
    }
}

// DFS
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        // id to Employee
        map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        
        return getImportance(map.get(id));
    }
    public int getImportance(Employee cur) {
        // Exit
        if (cur.subordinates.size() == 0) {
            return cur.importance;
        }
        
        int importance = cur.importance;
        for (int i = 0; i < cur.subordinates.size(); i++) {
            importance += getImportance(map.get(cur.subordinates.get(i)));
        }
        
        return importance;
    }
}