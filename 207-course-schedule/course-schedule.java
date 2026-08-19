class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> cs = new ArrayList<>();   
        
        for(int i = 0; i < numCourses; i++){
            cs.add(new ArrayList<>());
        }

        for(int[] course: prerequisites){

            int a = course[1];
            int b = course[0];
            cs.get(a).add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        
        //finding inDegrees
        for(ArrayList<Integer> list : cs){
            for(int num: list){
                inDegree[num]++;
            }
        }

        //finding the first element to start with whose inDegree is zero
        for(int i = 0 ; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        if(q.isEmpty()) return false;

        int courseCompleted = 0;

        while(!q.isEmpty()){

            int course = q.poll();
            courseCompleted++;

            for(int nextCourse: cs.get(course)){

                inDegree[nextCourse]--;

                if(inDegree[nextCourse] == 0){
                    q.offer(nextCourse);
                }
            }


        }
        return courseCompleted == numCourses;
    }
}