import java.util.Arrays;

class Main {
    class Unit {
        public int HP;
        public Unit() {
            this.HP = 1000;
        }
        public void underAttack(int damage) { }
    }

    class Monster extends Unit {
        public int attackPoint;
        public Monster(int attackPoint) {
            this.attackPoint = attackPoint;
        }
        public void underAttack(int damage) {
            this.HP -= damage;
        }
        public Integer attack() {
            return attackPoint;
        }
    }

    class Warrior extends Unit {
        public int attackPoint;
        public Warrior(int attackPoint) {
            this.attackPoint = attackPoint;
        }
        public void underAttack(int damage) {
            this.HP -= damage;
        }
        public Integer attack() {
            return attackPoint;
        }
    }

    class Healer extends Unit {
        public int healingPoint;
        public Healer(int healingPoint) { 
            this.healingPoint = healingPoint;
        }
        public void underAttack(int damage) {
            this.HP -= damage;
        }
        public void healing(Unit unit) {
            unit.HP += healingPoint;
        }
    }
    public int[] solution(int monsterAttackPoint, int warriorAttackPoint, int healingPoint) {
        Monster monster = new Monster(monsterAttackPoint);
        Warrior warrior = new Warrior(warriorAttackPoint);
        Healer healer = new Healer(healingPoint);
        
        //전사가 몬스터를 한 번 공격
        monster.underAttack(warrior.attack());
        //몬스터가 전사를 한 번 공격
        warrior.underAttack(monster.attack());
        //몬스터가 힐러를 한 번 공격
        healer.underAttack(monster.attack());
        //힐러가 전사의 체력을 한 번 회복
        healer.healing(warrior);
        //힐러가 몬스터의 체력을 한 번 회복
        healer.healing(monster);

        int[] answer = {monster.HP, warrior.HP, healer.HP};
        return answer;
    }


