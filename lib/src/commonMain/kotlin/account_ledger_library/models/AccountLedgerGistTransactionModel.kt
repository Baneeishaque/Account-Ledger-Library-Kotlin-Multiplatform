package account_ledger_library.models

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable

@Serializable
data class AccountLedgerGistTransactionModel(
    @Required val transactionParticulars: String,
    @Required val transactionAmount: Double
)
