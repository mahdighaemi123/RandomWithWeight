import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Sample();
        TestRandomWithWeight();
    }

    public static void Sample(){

        RandomWithWeight  randomWithWeight = new RandomWithWeight();

        randomWithWeight.addElement("Hi",10);
        randomWithWeight.addElement("World",1);

        System.out.println("Sample Out -> "+randomWithWeight.getRandomElement());
    }


    public static void TestRandomWithWeight(){

        String[] Names = {"a","b","c","d","e"};
        Integer[] Weights = {10000,1000,100,10,1};
        Integer[] CountRepeat = {0,0,0,0,0};

        int TotalWeight = 0;
        int TestCount = 10000;

        RandomWithWeight  randomWeight = new RandomWithWeight();

        for (int i=0;i<Names.length;i++){
            randomWeight.addElement(Names[i],Weights[i]);
            TotalWeight+= Weights[i];
        }

        for (int j=0;j<TestCount;j++){

            String Output = randomWeight.getRandomElement();

            for (int t =0 ; t< Names.length;t++) {

                if (Names[t].equals(Output)) {
                    CountRepeat[t]++;
                }

            }

        }

        System.out.println();
        System.out.println();
        System.out.println("Test Out");

        for (int h = 0;h<Names.length;h++){

            float GetPercentage = (float)CountRepeat[h]/(float) TestCount *100 ;
            float WeightPercentage = (float)Weights[h]/(float) TotalWeight *100 ;

            System.out.println();
            System.out.println(" Name             : "+Names[h]);
            System.out.println(" Weight           : "+Weights[h]);
            System.out.println(" CountRepeat      : "+CountRepeat[h]);
            System.out.println(" TotalRepeat      : "+TestCount);
            System.out.println(" GetPercentage    : "+GetPercentage );
            System.out.println(" WeightPercentage : "+WeightPercentage );
        }

    }

    public static class RandomWithWeight{

        List<ElementInfo> Elements = new ArrayList<>();

        public void addElement(String Element,int Weight){
            ElementInfo  elementInfo=new ElementInfo() ;
            elementInfo.ElementName = Element;
            elementInfo.ElementWeight = Weight;
            Elements.add(elementInfo);
        }

        public String getRandomElement(){

            int TotalWeight = getTotalElementsWeights();
            int PositionWeight = (int) Random(0,TotalWeight);
            int IndexInArray = FindIndexWeightInArray(PositionWeight);

            return Elements.get(IndexInArray).ElementName;
        }

        private int FindIndexWeightInArray(int Weight){

            int SearchPosition = 0 ;

            for (int i =0;i< Elements.size();i++){
                ElementInfo elementInfo =Elements.get(i);

                SearchPosition += elementInfo.ElementWeight;

                if (SearchPosition >= Weight ){
                    return i;
                }
            }

            return -1;
        }

        private int getTotalElementsWeights(){

            int TotalWeight = 0;

            for (int i=0;i<Elements.size();i++){
                TotalWeight += Elements.get(i).ElementWeight;;
            }

            return TotalWeight;

        }

        private long Random(int Min, int Max){
            return Math.round(Math.random()* (Max - Min) + Min);
        }

        private class ElementInfo{
            public String ElementName = "";
            public int ElementWeight = 0;
        }

    }

}