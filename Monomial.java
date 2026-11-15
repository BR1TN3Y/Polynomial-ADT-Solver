public class Monomial implements Comparable<Monomial> {
    private int coefficient;
    private int degree;

    /**
     * Constructor
     * @param coefficient
     * @param degree
     */
    public Monomial(int coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    /**
     * Getter method
     * @return coefficient
     */
    public int getCoefficient() {
        return coefficient;
    }

    /**
     * Getter method
     * @return degree
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Determine which Monomial has the higher degree.
     * @param m the object to be compared.
     * @return int
     */
    @Override
    public int compareTo(Monomial m) {
        return this.degree-m.degree;
    }
}
