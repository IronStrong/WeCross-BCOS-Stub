package com.webank.wecross.stub.bcos.contract;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.ExtendedRawTransaction;
import org.fisco.bcos.web3j.crypto.ExtendedTransactionEncoder;
import org.fisco.bcos.web3j.utils.BlockLimit;
import org.fisco.bcos.web3j.utils.Numeric;

public class SignTransaction {

    public static final BigInteger gasPrice = new BigInteger("300000000000");
    public static final BigInteger gasLimit = new BigInteger("300000000000");

    /**
     * create and sign the transaction
     *
     * @param credentials
     * @param contractAddress
     * @param groupId
     * @param chainId
     * @param blockNumber
     * @param abi
     * @return
     */
    public static String sign(
            Credentials credentials,
            String contractAddress,
            BigInteger groupId,
            BigInteger chainId,
            BigInteger blockNumber,
            String abi) {

        Random r = ThreadLocalRandom.current();
        BigInteger randomid = new BigInteger(250, r);
        BigInteger blockLimit = blockNumber.add(BigInteger.valueOf(BlockLimit.blockLimit));

        ExtendedRawTransaction rawTransaction =
                ExtendedRawTransaction.createTransaction(
                        randomid,
                        SignTransaction.gasPrice,
                        SignTransaction.gasLimit,
                        blockLimit,
                        contractAddress,
                        BigInteger.ZERO,
                        abi,
                        groupId,
                        chainId,
                        "");

        byte[] signedMessage = ExtendedTransactionEncoder.signMessage(rawTransaction, credentials);

        String signedData = Numeric.toHexString(signedMessage);

        return signedData;
    }
}
