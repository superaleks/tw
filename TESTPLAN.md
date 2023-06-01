# Trust Wallet - Complete Wallet Creation

## Business requirements

The user should be able to configure TrustWallet from scratch. 

## Test Scenarios

####  Welcome Screen 

#####  TC1 

1. Open Trust Wallet 
2. Make sure you are able to see 3 options (Create new wallet, Import or recover wallet, Ledger)
3. Select 'Create a new wallet' option

*Expected result:* You will be prompted to Set a password

*Actual result:*

#### Setting and Confirming Password 

#####  TC2 

1. Enter the password following the requirements
2. Confirm the password
3. Check the 'Terms of use' checkbox

*Expected result:* User is able to proceed to the next page

*Actual result:* 

#####  TC3

1. Enter the password without following the requirements
2. Confirm the same incorrect password
3. Check the 'Terms of use' checkbox

*Expected result:* "Passwords do not match" message is shown

*Actual result:*

#### Backup secret phase

#####  TC4

1. Click on "Other ways to keep it safe" link

*Expected result:* New tab of Support Trust Wallet documentation is opened.

*Actual result:*

#####  TC5

1. Click on "Start" button
2. Click on "Got it" button
3. Observe the secret phrase and copy it
4. Click on 'Proceed' button
5. Enter the secret phrase
6. Click on "Next" button
7. Click on "No, thanks" button

*Expected result:* 'Congratulations' message is shown and the user is prompted to Open wallet

*Actual result:*

#### Open created wallet

#####  TC6

1. Click on 'Open wallet' button
2. Make sure you see the 'How to access dApps' instruction popup
3. Click on 'Got it' button 
4. On "Manage all of your tokens easily" popup, click "I'm ready to use Trust Wallet"

*Expected result:* 0 balance is shown. The user can now observe multiple currencies wallets and start using the wallet

*Actual result:* 




