class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> cs = new ArrayList<>();   
        int[] inDegree = new int[numCourses];

      
        
        for(int i = 0; i < numCourses; i++){
            cs.add(new ArrayList<>());
        }

        for(int[] course: prerequisites){

            int cour = course[0];
            int preReq = course[1];
            cs.get(preReq).add(cour);

            //we can find the inDegree here only
            inDegree[cour]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        //finding inDegrees
        // for(ArrayList<Integer> list : cs){
        //     for(int num: list){
        //         inDegree[num]++;
        //     }
        // }

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