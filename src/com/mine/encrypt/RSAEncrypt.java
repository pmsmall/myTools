package com.mine.encrypt;

import java.math.BigInteger;
import java.util.Random;

public class RSAEncrypt {


	    private int securityParam;
	    private Random random;
	    private BigInteger bigIntN;
	    private BigInteger bigIntP;
	    private BigInteger bigIntQ;

	    private BigInteger bigIntPhiN;
	    private BigInteger e;
	    private BigInteger d;

	    public RSAEncrypt(int securityParam) {
	        this.securityParam = securityParam;
	        this.random = new Random();
	        this.bigIntP = null;
	        this.bigIntQ = null;
	        while (true) {
	            try {
	                //In some cases, e does not have inverse in phi(N), repeat until find valid phi(N)
	                bigIntP = BigInteger.probablePrime(securityParam / 2, random);
	                bigIntQ = BigInteger.probablePrime(securityParam / 2, random);
	                this.bigIntN = bigIntP.multiply(bigIntQ);
	                this.bigIntPhiN = this.bigIntN.subtract(bigIntP).subtract(bigIntQ).add(BigInteger.ONE);
	                //We choose a recommended public key e = 65537
	                this.e = new BigInteger("65537");
	                this.d = e.modInverse(bigIntPhiN);
	                break;
	            } catch (ArithmeticException e) {
	                continue;
	            }
	        }
	    }

	    public void setE(BigInteger bigIntE) {
	        while (true) {
	            try {
	                //In some cases, e does not have inverse in phi(N), repeat until find valid phi(N)
	                this.bigIntP = BigInteger.probablePrime(securityParam / 2, random);
	                this.bigIntQ = BigInteger.probablePrime(securityParam / 2, random);
	                this.bigIntN = bigIntP.multiply(bigIntQ);
	                this.bigIntPhiN = this.bigIntN.subtract(bigIntP).subtract(bigIntQ).add(BigInteger.ONE);
	                //We choose a recommended public key e = 65537
	                this.e = bigIntE;
	                this.d = e.modInverse(bigIntPhiN);
	                break;
	            } catch (ArithmeticException e) {
	                continue;
	            }
	        }
	    }

	    public void setD(BigInteger bigIntD) {
	        while (true) {
	            try {
	                //In some cases, e does not have inverse in phi(N), repeat until find valid phi(N)
	                this.bigIntP = BigInteger.probablePrime(securityParam / 2, random);
	                this.bigIntQ = BigInteger.probablePrime(securityParam / 2, random);
	                this.bigIntN = bigIntP.multiply(bigIntQ);
	                this.bigIntPhiN = this.bigIntN.subtract(bigIntP).subtract(bigIntQ).add(BigInteger.ONE);
	                //We choose a recommended public key e = 65537
	                this.d = bigIntD;
	                this.e = d.modInverse(bigIntPhiN);
	                break;
	            } catch (ArithmeticException e) {
	                continue;
	            }
	        }
	    }

	    public void setPandQ(BigInteger bigIntP, BigInteger bigIntQ) {
	        this.bigIntN = bigIntP.multiply(bigIntQ);
	        this.bigIntPhiN = this.bigIntN.subtract(bigIntP).subtract(bigIntQ).add(BigInteger.ONE);
	        BigInteger bigIntE = new BigInteger("65537");
	        while (true) {
	            try {
	                //In some cases, e does not have inverse in phi(N), repeat until find valid phi(N)
	                this.e = bigIntE;
	                this.d = e.modInverse(bigIntPhiN);
	                break;
	            } catch (ArithmeticException e) {
	                bigIntE = bigIntE.add(BigInteger.ONE);
	                continue;
	            }
	        }
	    }

	    public BigInteger getE() {
	        return this.e;
	    }

	    public BigInteger getD() {
	        return this.d;
	    }

	    public BigInteger getN() {
	        return this.bigIntN;
	    }

	    public BigInteger getP() { return this.bigIntP; }

	    public BigInteger getQ() { return this.bigIntQ; }

	    public byte[] encrypt(String message) {
	        byte[] byteMessage = message.getBytes();
	        BigInteger bigIntMessage = new BigInteger(byteMessage);
	        if (bigIntMessage.compareTo(this.bigIntN) >= 0) {
	            throw new RuntimeException("Message is bigger than N");
	        }
	        return bigIntMessage.modPow(this.e, this.bigIntN).toByteArray();
	    }

	    public String decrypt(byte[] ciphertext) {
	        BigInteger bigIntCiphertext = new BigInteger(ciphertext);
	        byte[] byteMessage = bigIntCiphertext.modPow(this.d, this.bigIntN).toByteArray();
	        return new String(byteMessage);
	    }
	
}
