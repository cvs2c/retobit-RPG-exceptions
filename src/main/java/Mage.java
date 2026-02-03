public class Mage extends Character {
    private int mana;


    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public static void checkMana(int manaCost, int currentMana, String mageName) throws InsufficientManaException{
        if(manaCost > currentMana){
            throw new InsufficientManaException( mageName + " no tiene maná suficiente");
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

    public int getMana() {
        return this.mana;
    }

    public void castSpell(Character target) {

        checkTargetNotNull(target);
        checkIsAlive(target);

        if (this.mana - 10 >= 0) {
            this.mana -= 10;
            target.receiveDamage(20);
            target.status = Status.POISONED;
        }

        checkMana(10, this.mana, this.name);

    }

    public void heal(Character target) {
            checkMana(15, this.mana, this.name);
            checkTargetNotNull(target);
            checkIsAlive(target);
            this.mana -= 15;
            target.health += 20;
    }

}
