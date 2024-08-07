package account_ledger_library.models

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable

@Serializable
data class AccountLedgerGistModelV2(
    @Required val userName: String,
    @Required val userId: UInt,
    //TODO : Include A/C Name
    @Required val accountLedgerPages: LinkedHashMap<UInt, LinkedHashMap<String, AccountLedgerGistDateLedgerModel>>
)

@Serializable
data class AccountLedgerGistModelV3(
    @Required val userName: String,
    @Required val userId: UInt,
    @Required val accountLedgerPages: MutableList<AccountLedgerPage>
)

@Serializable
data class AccountLedgerPage(
    @Required val accountId: UInt,
    @Required val transactionDatePages: MutableList<TransactionDatePage>
)

@Serializable
data class TransactionDatePage(
    @Required val transactionDate: String,
    @Required val initialBalance: Double?,
    @Required val transactions: List<AccountLedgerGistTransactionModel>?,
    @Required val finalBalance: Double?
)

@Serializable
data class AccountLedgerGistDateLedgerModel(
    var initialBalanceOnDate: Double? = null,
    @Required var transactionsOnDate: MutableList<AccountLedgerGistTransactionModel>,
    var finalBalanceOnDate: Double? = null
)
