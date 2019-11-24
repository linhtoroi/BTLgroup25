package Main;

import javafx.scene.image.ImageView;

public abstract class Tower extends GameTile{
        protected int attackDame;
        protected double attackSpeed;
        double radiusAttack;

        public ImageView imageView;

        public Tower(double x, double y){
                coordinate = new Point(x*40,y*40);
                attackDame = 10;
                attackSpeed = 0.7;

                radiusAttack = 150;
        }
        void upgradeTower(){
                attackSpeed++;
                attackDame++;
                attackSpeed++;
                radiusAttack++;
        }
        public int getAttackDame() {
                return attackDame;
        }

        public double getAttackSpeed() {
                return attackSpeed;
        }

        public void setAttackDame(int attackDame) {
                this.attackDame = attackDame;
        }


        public void setRadius(double radius) {
                this.radiusAttack = radius;
        }

        public double getRadius() {
                return radiusAttack;
        }
        public void setAttackSpeed(double attackSpeed){
                this.attackSpeed = attackSpeed;
        }
}
