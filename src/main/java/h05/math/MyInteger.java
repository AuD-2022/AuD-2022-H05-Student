package h05.math;

import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Represents an integer in Racket.
 *
 * @author Nhan Huynh
 */
public final class MyInteger extends MyNumber {

    /**
     * The constant {@link MyNumber} 0 as a {@link MyInteger}.
     */
    public static final MyNumber ZERO = new MyInteger(BigInteger.ZERO);

    /**
     * The constant {@link MyNumber} 1 as a {@link MyInteger}.
     */
    public static final MyNumber ONE = new MyInteger(BigInteger.ONE);

    /**
     * The value of the integer.
     */
    private final BigInteger value;

    /**
     * Constructs and initializes an integer with the specified value.
     *
     * @param value the value of the real number
     * @throws NullPointerException if the value is null
     */
    public MyInteger(BigInteger value) {
        this.value = Objects.requireNonNull(value, "value null");
    }

    @Override
    public BigInteger toInteger() {
        return value;
    }

    @Override
    public Rational toRational() {
        throw new RuntimeException("H1.2 not implemented"); // TODO: remove if H1.2 implemented
    }

    @Override
    public BigDecimal toReal() {
        throw new RuntimeException("H1.2 not implemented"); // TODO: remove if H1.2 implemented
    }

    @Override
    public boolean isZero() {
        return this.equals(ZERO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MyInteger number)) {
            return false;
        }
        return value.equals(number.value);
    }

    @Override
    public MyNumber negate() {
        return new MyInteger(value.negate());
    }

    @Override
    public MyNumber plus(MyNumber other) {
        if (other instanceof MyInteger) {
            return new MyInteger(value.add((other.toInteger())));
        }
        if (other instanceof MyReal) {
            return checkRealToInt(toReal().add(other.toReal()));
        }
        return checkRationalToInt(other.toRational().plus(value));
    }

    @Override
    public MyNumber minus() {
        throw new RuntimeException("H2.1 - not implemented"); // TODO: H2.1 - remove if implemented
    }

    @Override
    public MyNumber minus(MyNumber other) {
        throw new RuntimeException("H2.1 - not implemented"); // TODO: H2.1 - remove if implemented
    }

    @Override
    public MyNumber times(MyNumber other) {
        if (other instanceof MyInteger) {
            return new MyInteger(value.multiply(other.toInteger()));
        }
        if (other instanceof MyReal) {
            return checkRealToInt(toReal().multiply(other.toReal()));
        }
        return checkRationalToInt(other.toRational().times(value));
    }

    @Override
    public MyNumber divide() {
        throw new RuntimeException("H2.1 - not implemented"); // TODO: H2.1 - remove if implemented
    }

    @Override
    public MyNumber divide(MyNumber other) {
        throw new RuntimeException("H2.1 - not implemented"); // TODO: H2.1 - remove if implemented
    }

    @Override
    public MyNumber sqrt() {
        throw new RuntimeException("H2.2 - not implemented"); // TODO: H2.2 - remove if implemented
    }

    @Override
    public MyNumber expt(MyNumber n) {
        throw new RuntimeException("H2.2 - not implemented"); // TODO: H2.2 - remove if implemented
    }

    @Override
    public MyNumber exp() {
        throw new RuntimeException("H2.2 - not implemented"); // TODO: H2.2 - remove if implemented
    }

    @Override
    public MyNumber ln() {
        throw new RuntimeException("H2.2 - not implemented"); // TODO: H2.2 - remove if implemented
    }

    @Override
    public MyNumber log(MyNumber base) {
        throw new RuntimeException("H2.2 - not implemented"); // TODO: H2.2 - remove if implemented
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
