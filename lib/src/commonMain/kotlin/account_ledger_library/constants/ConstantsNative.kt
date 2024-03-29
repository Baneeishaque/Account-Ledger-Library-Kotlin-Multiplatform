package account_ledger_library.constants

import common_utils_library.constants.ConstantsCommonNative


object ConstantsNative {

    const val TRANSACTION_TEXT: String = "Transaction"
    const val defaultValueForStringEnvironmentVariables: String = "N/A"
    const val defaultValueForIntegerEnvironmentVariables: Int = 0
    const val accountText: String = "Account"
    const val SPECIAL_TEXT = "Special"
    const val TYPE_TEXT = "Type"
    const val SPECIAL_TRANSACTION_TYPE_TEXT: String = "$SPECIAL_TEXT $TRANSACTION_TEXT $TYPE_TEXT"
    const val userText: String = "User"
    const val frequencyOfAccountsFileName = "frequencyOf${accountText}s.json"
    val SPECIAL_TRANSACTION_TYPES_FILE_NAME = "${SPECIAL_TEXT.lowercase()}${TRANSACTION_TEXT}${TYPE_TEXT}s.json"
    const val accountHeaderIdentifier: String = "A/C Ledger "
    const val walletAccountHeaderIdentifier: String = "Wallet"

    //    internal const val bankAccountHeaderIdentifier: String = "Bank"
    const val bankAccountHeaderIdentifier: String = "PNB"
    const val accountHeaderUnderlineCharacter: Char = '~'
    const val accountBalanceHolderOpeningBrace: Char = '{'
    const val dateUnderlineCharacter: Char = '~'
    const val finalBalancePrefixCharacter: Char = '='

    const val timeResetCommandIndicator = "Tr"
    val timeResetPatternRegex: Regex =
        Regex("$timeResetCommandIndicator${ConstantsCommonNative.railwayTimeRegexPattern}")

    const val hourIncrementOrDecrementCommandIndicator = "H"
    val hourIncrementOrDecrementPatternRegex: Regex =
        Regex("$hourIncrementOrDecrementCommandIndicator${ConstantsCommonNative.digitIncrementOrDecrementRegexPattern}")

    const val minuteIncrementOrDecrementCommandIndicator = "M"
    val minuteIncrementOrDecrementPatternRegex: Regex =
        Regex("$minuteIncrementOrDecrementCommandIndicator${ConstantsCommonNative.digitIncrementOrDecrementRegexPattern}")

    const val secondIncrementOrDecrementCommandIndicator = "S"
    val secondIncrementOrDecrementPatternRegex: Regex =
        Regex("$secondIncrementOrDecrementCommandIndicator${ConstantsCommonNative.digitIncrementOrDecrementRegexPattern}")

    const val dayIncrementOrDecrementCommandIndicator = "D"
    val dayIncrementOrDecrementPatternRegex: Regex =
        Regex("$dayIncrementOrDecrementCommandIndicator${ConstantsCommonNative.digitIncrementOrDecrementRegexPattern}")

    val dayIncrementOrDecrementWithTimeResetPatternRegex =
        Regex("($dayIncrementOrDecrementCommandIndicator${ConstantsCommonNative.digitIncrementOrDecrementRegexPattern})($timeResetCommandIndicator${ConstantsCommonNative.railwayTimeRegexPattern})")

    const val accountIdPrefix = '['
    const val accountIdSuffix = ']'

    const val ID_TEXT = "ID"
    const val BAJAJ_COINS_TEXT = "Bajaj-Coins"
    const val BAJAJ_COINS_INCOME_TEXT = "$BAJAJ_COINS_TEXT-Income"
    const val BAJAJ_COINS_INCOME_ACCOUNT_ID_TEXT = "$BAJAJ_COINS_INCOME_TEXT-$accountText $ID_TEXT"
    const val BAJAJ_COINS_WALLET_TEXT = "$BAJAJ_COINS_TEXT-Wallet"
    const val BAJAJ_COINS_WALLET_ACCOUNT_ID_TEXT = "$BAJAJ_COINS_WALLET_TEXT-$accountText $ID_TEXT"
    const val BAJAJ_COINS_CONVERSION_RATE_TEXT = "$BAJAJ_COINS_TEXT-Conversion-Rate"

    const val USER_CANCELLED_TRANSACTION_TEXT = "${ConstantsCommonNative.USER_CANCELLED_TEXT} $TRANSACTION_TEXT"

    const val DATE_FROM_USERNAME_ERROR = "Error: Can't derive date from username..."
}