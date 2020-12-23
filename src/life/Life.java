package life;

public class Life {

    public boolean evolve(Cell cell){
        boolean didEvolve = false;
        if(cell.getCellCount() > cell.getEvolveRequirements()) {
            cell.setEvolve();
            cell.mutate(cell.getEvolveRequirements());
            cell.setCellCount(cell.getCellCount() - cell.getEvolveRequirements());
            cell.nextLvl(cell.getEvolveLvl() + 1);
            System.out.printf("Evolved, current level: %d%n", cell.getEvolveLvl());
            System.out.printf("Used 10 cells, currently have %d cells left%n", cell.getCellCount());
            didEvolve = true;
        } else {
            System.out.printf("Can not evolve yet, only have %d cells, required %d cells%n", cell.getCellCount(), cell.getEvolveRequirements());
        }
        return didEvolve;
    }

    public void die(){
        System.out.println("Died");
    }
}
