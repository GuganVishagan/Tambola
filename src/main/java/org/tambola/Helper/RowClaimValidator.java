package org.tambola.Helper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RowClaimValidator {

    public boolean isWinner(String[][] tambolaTicket, List<Integer> announcedNumbers, int rowIndex){
        Set<Integer> announcedNumbersHashSet = new HashSet<Integer>(announcedNumbers);
        boolean winner = false;
        for(int i=0;i<tambolaTicket[0].length;i++){
            String cell = tambolaTicket[rowIndex][i];
            if(!cell.equals("_")){
                if(announcedNumbersHashSet.contains(Integer.parseInt(cell))){
                    winner = true;
                }
                else {
                    winner = false;
                    break;
                }
            }
        }
        if(!winner){
            return false;
        }
        for(int j=0;j<tambolaTicket[0].length;j++){
            String cell = tambolaTicket[rowIndex][j];
            if(!cell.equals("_") && announcedNumbers.get(announcedNumbers.size()-1) == Integer.parseInt(cell)){
                return true;
            }
        }
        return false;
    }

}
