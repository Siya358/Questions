class Solution {
    public int[] countMentions(int numberOfUser, List<List<String>> events) {
        int all=0;
        Collections.sort(events,(a,b)->{
            int x=Integer.valueOf(a.get(1));
            int y=Integer.valueOf(b.get(1));
            if(x==y){
                if(a.get(0).equals("OFFLINE")){
                    return -1;
                }
            }
            return x<y?-1:1;
        });
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int online[]=new int[numberOfUser];
        Arrays.fill(online,1);
        int mention[]=new int[numberOfUser];
        for(List<String> l:events){
            int curTime=Integer.valueOf(l.get(1));

            while(!pq.isEmpty() && pq.peek()[0]<=curTime){
                online[pq.peek()[1]]=1;
                pq.poll();
            }
            if(l.get(0).equals("MESSAGE")){
                if(l.get(2).equals("ALL")){
                    all++;
                }
                else if(l.get(2).equals("HERE")){
                    for(int i=0;i<numberOfUser;i++){
                        if(online[i]==1){
                            mention[i]++;
                        }
                    }
                }
                else{
                    String s[]=l.get(2).split(" ");
                    for(String g:s){
                        String res=g.substring(2,g.length());
                        int v=Integer.valueOf(res);
                        mention[v]++;
                    }
                    
                    
                }
            }
            else{
                int ts=Integer.valueOf(l.get(1));
                int id=Integer.valueOf(l.get(2));
                online[id]=0;
                pq.offer(new int[]{ts+60,id});
            }
        }

        for(int k=0;k<numberOfUser;k++){
            mention[k]+=all;
        }
        return mention;
    }
}