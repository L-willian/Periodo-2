// SimpleStartup.java, codigo base.
class SimpleStartup {
    private int[] locationCells;
    private int numOfHits=0;

    public void setLocations(int [] locs){
        locationCells = locs;
    }

    public String checkYourself(int guess){
        String result = "miss";
        // for (int cell: locationCells){
        for (int i=0; i < locationCells.length;i++){
            if (guess == locationCells[i]){
                result = "hit";
                numOfHits++;
                locationCells[i]=-1;
                break;
            }
            
        }
        if (numOfHits == locationCells.length){
            result = "kill";
        }

        System.out.println(result);
        return result;
    }

    public int getHits(){
        return numOfHits;
    }

}