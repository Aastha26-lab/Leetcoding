class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(List<Integer> oneConnection:connections){
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        
        int timer[]= new int[1];
        List<List<Integer>> results=new ArrayList<>();
        boolean[] visited=new boolean[n];
        int[] timeStamp=new int[n];
        function(graph,-1,0,timer,visited,results,timeStamp);
        return results;
    }
    
    public void function(List<Integer>[] graph,int parent,int node,int[] timer,boolean[] visited,List<List<Integer>> results,int[] timeStamp){
        visited[node]=true;
        timeStamp[node]=timer[0]++;
        int currentTimeStamp=timeStamp[node];
        
        for(int neighbor:graph[node]){
            if(neighbor==parent){
                continue;
            }
            
            if(!visited[neighbor]){
                function(graph,node,neighbor,timer,visited,results,timeStamp);
                
            }
            timeStamp[node]=Math.min(timeStamp[node],timeStamp[neighbor]);
            if(currentTimeStamp<timeStamp[neighbor]){
                    results.add(Arrays.asList(node,neighbor));
                }
        }
    }
    
}