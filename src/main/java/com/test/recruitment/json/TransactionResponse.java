package com.test.recruitment.json;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Transaction json representation
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransactionResponse extends AbstractTransaction implements Serializable {

    private static final long serialVersionUID = -2371720864101586328L;

    @NotNull
    private String id;

}
