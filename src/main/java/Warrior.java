import java.lang.annotation.Target;

public class Warrior extends Character {
    int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    /*Validaciones*/
    public static void checkBerserkMode(Status status, String warrior) throws BerserkAlreadyActiveException{
        if(status == Status.FURIOUS){
            throw new BerserkAlreadyActiveException(warrior + " ya está en modo furioso");
        }
    }

    public static void checkTargetNotNull(Character target) throws InvalidTargetException{
        if(target == null){
            throw new InvalidTargetException("No se puede realizar una acción a un objetivo nulo");
        }
    }

    public static void checkIsAlive(Character target) throws CharacterAlreadyDeadException{
        if(!target.isAlive()){
            throw new CharacterAlreadyDeadException( target.name + " ya está muerto");
        }
    }

    public int getStrength() {
        return this.strength;
    }

    public void performHeavyAttack(Character target) {
        checkTargetNotNull(target);
        checkIsAlive(target);
        target.receiveDamage(this.strength);
    }

    public void enterBerserkMode() {
            checkBerserkMode(this.status, this.name);
            this.status = Status.FURIOUS;
    }
}
