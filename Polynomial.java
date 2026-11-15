public class Polynomial {
    private OrderedLinkedList<Monomial> linkedList;

    /**
     * Constructor
     */
    public Polynomial() {
        this.linkedList = new OrderedLinkedList<>();
    }

    /**
     * Function that add a new monomial to the polynomial.
     * @param coefficient
     * @param degree
     */
    public void add(int coefficient,int degree){
        Monomial temp = new Monomial(coefficient,degree);
        linkedList.insert(temp);
    }

    /**
     * Derivative method
     * @return new polynomial object
     */
    public Polynomial derivative(){
        Polynomial derivativePolynomial = new Polynomial();

        for (int i =0; i<linkedList.getSize();i++){
            int coefficient = linkedList.get(i).getCoefficient();
            int degree = linkedList.get(i).getDegree();

            if (degree > 0) {
                int derivativeCoefficient = coefficient * degree;
                int derivativeDegree = degree - 1;
                derivativePolynomial.add(derivativeCoefficient, derivativeDegree);
            }
        }
        return derivativePolynomial;
    }

    /**
     * Function that evaluates the polynomial.
     * @param z
     * @return double
     */
    public double eval (double z){
        //z represent f(z)
        double result=0;
        //loop through OrderLinkList to sum the result
        for (int i = 0; i < linkedList.getSize(); i++) {
            int coefficient = linkedList.get(i).getCoefficient();
            int degree = linkedList.get(i).getDegree();
            result += coefficient * Math.pow(z, degree);
        }
        return result;
    }

    /**
     * Printing all the nonzero monomials in the polynomial.
     * @return String
     */
    public String toString(){
        String str="";
        if (linkedList.getSize()==0)return str;
        for (int i = 0; i < linkedList.getSize(); i++) {
            int coefficient = linkedList.get(i).getCoefficient();
            int degree = linkedList.get(i).getDegree();
            if (i==0){
                str += coefficient+"*x^"+degree;
            }
            else {
                if (coefficient>0){
                    str+=" + ";
                    str += coefficient+"*x^"+degree;
                } else if (coefficient<0) {
                    str += " - ";
                    str += coefficient * (-1) + "*x^" + degree;
                }
            }
        }
        return  str;
    }

    /**
     * Apply Newton's Method to derive the result
     * @param x0
     * @param e
     * @param T
     * @return
     * @throws SolutionNotFound
     */
    public double solve(double x0, double e, int T) throws SolutionNotFound {
        double previous = x0;
        double current;
        int counter;
        if (derivative().eval(previous)!=0){
            current  = previous-(eval(previous)/ derivative().eval(previous));
        }
        else{
            throw new SolutionNotFound("divide by zero error");
        }
        for (counter =1;counter<=T && Math.abs(previous-current)>e;counter++){
            previous=current;
            if (derivative().eval(previous)!=0){
                current=previous-(eval(previous)/ derivative().eval(previous));
            }
            else throw new SolutionNotFound("divide by zero error");
        }
        if (counter>=T)throw new SolutionNotFound("maximum iteration exceeded");
        else return current;
    }
}
