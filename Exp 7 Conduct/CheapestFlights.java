package class conduct 4;

public class CheapestFlights {
    class Pair{
        int first;
        int second;

        public Pair(int first ,int second){
            this.first=first;
            this.second=second;
        }
    }

    class Tuple{
        int stop;
        int node;
        int cost;

        public Tuple(int stop,int node, int cost){
            this.stop=stop;
            this.node=node;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int [] distance = new int[n];
        for(int i=0;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        
        while(!q.isEmpty()){
            Tuple t=q.poll();
            int node=t.node();
            int cost=t.cost;
            int stop=t.stop;

            for(Pair p:adj.get(node)){
                int adjN=p.first;
                int adjC=p.second;

                

            }

        }
        if(distance[dst]==Integer.MAX_VALUE) return -1;
        return distance[dst];
    }
}
