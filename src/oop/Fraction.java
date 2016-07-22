package oop;


public class Fraction {
    public int numerator;
    public int denominator;

    public Fraction (int num, int den){
        if (den == 0) {
            throw new IllegalArgumentException("Argument 'denominator' is 0");
        }
        numerator = num;
        denominator = den;
        reduce();
    }

    public Fraction (double d){
        String fracBuff = Double.toString(d);
        int i = fracBuff.indexOf('.');
        if (i<0){
            numerator = (int)d;
            denominator = 1;
        } else {
            Fraction intg;
            Fraction frac;

            try{
                int integer = Integer.parseInt(fracBuff.substring(0, i));
                int fractional = Integer.parseInt(fracBuff.substring(i + 1));
                intg = new Fraction(integer,1);
                frac = new Fraction(fractional, (int)Math.pow(10,fracBuff.substring(i + 1).length()));
            } catch (NumberFormatException nfe){
                int integer = Integer.parseInt(fracBuff.substring(0, i));
                int fractional = Integer.parseInt(fracBuff.substring(i + 1,i+4));
                intg = new Fraction(integer,1);
                frac = new Fraction(fractional, (int)Math.pow(10,fracBuff.substring(i + 1, i + 4).length()));
            }

            this.numerator = intg.numerator*frac.denominator+frac.numerator;
            this.denominator = frac.denominator;
            this.reduce();
        }
    }

    public double value(){
        return (double)numerator/(double)denominator;
    }

    public void print() {
        System.out.println("Value of fraction is "+numerator+"/"+denominator+"="+value());
    }

    public Fraction sum(Fraction add){
        double d = this.value()+add.value();
        return new Fraction(d);
    }

    void reduce () {
        double max = 0;
        if (numerator>denominator) max = Math.abs(denominator);
        else max = Math.abs(numerator);
        for (double i = max; i>=2;i--){
            if ((numerator%i==0)&&(denominator%i==0)){
                numerator /= i;
                denominator /= i;
            }
        }
    }

    public Fraction mul(double mul) {
        double d = this.value()*mul;
        return new Fraction(d);
    }

    public Fraction sub(double sub) {
        double d = this.value()/sub;
        return new Fraction(d);
    }


}
