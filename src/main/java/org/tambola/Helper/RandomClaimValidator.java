package org.tambola.Helper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomClaimValidator {

    public boolean isWinner(String[][] tambolaTicket, List<Integer> announcedNumbers, int gameCountFactor){
        Set<Integer> announcedNumbersHashSet = new HashSet<Integer>(announcedNumbers);
        int counter = 0;;
        boolean winner = false;
        for(int i=0;i<tambolaTicket.length;i++){
            for(int j=0;j<tambolaTicket[i].length;j++){
                String cell = tambolaTicket[i][j];
                if(!cell.equals("_") && announcedNumbersHashSet.contains(Integer.parseInt(cell))){
                    winner = true;
                    counter = counter +1;
                }
            }
        }

        if(!winner || counter != gameCountFactor){
            return false;
        }

        for(int i=0;i<tambolaTicket.length;i++){
            for(int j=0;j<tambolaTicket[i].length;j++){
                String cell = tambolaTicket[i][j];
                if(!cell.equals("_") && announcedNumbers.get(announcedNumbers.size()-1) == Integer.parseInt(cell)){
                    return true;
                }
            }
        }

        return false;
    }

}
