package com.test.recruitment.tests;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Account test
 */
public class TransactionTest extends AbstractTest {

    @Test
    public void getTransactions() throws Exception {
        mockMvc.perform(get("/accounts/1/transactions"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.totalElements", is(3)))
            .andExpect(jsonPath("$.content[0].number", is("12151885120")))
            .andExpect(jsonPath("$.content[0].balance", is(42.12)));
    }

    @Test
    public void getTransactionsNoContent() throws Exception {
        mockMvc.perform(get("/accounts/2/transactions"))
            .andExpect(status().isNoContent());
    }

    @Test
    public void getTransactionsOnNonExistingAccount() throws Exception {
        mockMvc.perform(get("/accounts/3/transactions"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.errorCode", is("NOT_FOUND")));
    }

}
