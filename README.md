# RandomWithWeight
Get Random Key With Weight

## Use
```
RandomWithWeight  randomWithWeight = new RandomWithWeight();
randomWithWeight.addElement(myKey,myWeight);
System.out.println("Out -> "+randomWithWeight.getRandomElement()); 
```

## Sample
```
RandomWithWeight  randomWithWeight = new RandomWithWeight();
randomWithWeight.addElement("A",10);
randomWithWeight.addElement("B",90);
System.out.println("Sample Out -> "+randomWithWeight.getRandomElement()); 
```
#### Output
  - Output A is likely to be 10%
  - Output B is likely to be 90%
  
  
  ## Sample -2
```
RandomWithWeight  randomWithWeight = new RandomWithWeight();
randomWithWeight.addElement("A",10);
randomWithWeight.addElement("B",90);
randomWithWeight.addElement("C",100);
System.out.println("Sample Out -> "+randomWithWeight.getRandomElement()); 
```
#### Output -2
  - Output A is likely to be 10/200
  - Output B is likely to be 90/200
  - Output B is likely to be 100/200
