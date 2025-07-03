# Data-Encryption-Service
a program that is capable of encrypting and decrypting data withh the use of a user provided password.

This README file will contain instructions on how to use this program along with warnings when it comes to using this program to encrypt files.

_____________________________________________________________________________________________________________________________________________

WARNINGS AND HEADS UP ABOUT PROGRAM USE:
the following are warnings and other important information about the program that the user must know in advance.

1. DO NOT USE PERSONAL INFORMATION WHEN USING THIS PROGRAM
even in its final functional state, this program is ultimately a work in progress and contains certain faults that if the user is not careful, could result in the information that is being encrypted or decrypted being lost forever. 
Because of this, I would highly recommend not actually using this program to encrypt personal information like important information, family photoes and videos, etc.
I would recommend at least being very familiar with the use of this program and understanding its quirks and faults before attempting to use it for important personal information

2. REMEMBER YOUR PASSWORD.
if the user forgot the password they used to encrypt their input, then the program will not be able to perform decryption and the information that was decrypted will be lost. it is vital that the user remembers the encryption password as to not lose their information.

3. DECRYPTION OF A FILE ENCRYPTED WITH THIS PROGRAM MUST ALSO BE DONE USING THIS PROGRAM
if a file or text was encrypted using this program, then the user must also use this program to decrypt the encrypted message/file. because of the way that the program encrypts the data and stores certain information, decryption might not work using other decryption services, and the only way to decrypt the message will be to use this program to also perform the decryption.

4. SPECIFY THE FORMATS OF YOUR FILE OUTPUTS
THIS IS THE MOST IMPORTANT WARNING WHEN USING THIS PROGRAM.
WHEN USING EITHER ENCRYPTION OR DECRYPTION PAGES FOR IMAGE FILES OR OTHER FILE TYPES, IT IS IMPORTANT THAT THE USER SPECIFIES WHAT THE FILE TYPE OF THE OUTPUT WILL BE.
THIS WARNING APPLIES TO THE FOLLOWING ENCRYPTION AND DECRYPTION PAGES:
    Image File
    Other File Types
WHEN ENCRYPTING A FILE, THE USER MUST SPECIFY THAT THE OUTPUT WILL BE A TEXT FILE BY ADDING ".txt" TO THE END OF THE FILE NAME WHEN CHOOOSING WHERE TO STORE THE FILE. IF THIS IS NOT DONE, THEN THE PROGRAM WILL NOT SPECIFY THAT THE FILE NEEDS TO BE IN A .txt FILE AND THE PROGRAM WILL STORE THE ENCRYPTED BYTES IN A FILE WITHOUT A SPECIFIED FORMAT. THIS WILL RESULT IN THE ENCRYPTED BYTE INFORMATION OF THE ORIGINAL FILE TO BE INACCESSIBLE, RESULTING THE THE PROGRAM NOT BEING ABLE TO DECRYPT THE DATA AND THE ORIGINAL FILE BEING LOST.

SIMILAR TO ENCRYPTION, WHEN DECRYPTING A FILE IT IS IMPORTANT THAT THE USER SPECIFIES WHAT THE FORMAT OF THE ORIGINAL FILE WAS WHEN THEY ARE DECRYPTING THE TEXT FILES CONTAINING THE ENCRYPTED BYTES BACK INTO THE ORIGINAL FILE. IF THE USER DOES NOT DO THIS, THEN THE PROGRAM WILL ENCRYPT THE FILE IN AN UNSPECIFIED FORMAT, WHICH WILL RESULT IN THE CONTENTS OF THE FILE BEING INACCESSIBLE TO THE USER AND THE CONTENTS OF THE FILE POTENTIALLY BEING LOST.
_____________________________________________________________________________________________________________________________________________

LAUNCHING THE PROGRAM.
to launch the program, the user has to run the Launch.java class, which will start the program

1. Encrypting Text.
to enter the encrypt text page, the user has to go from Home Page --> Encrypt --> Plain Text. once in the plaintext encryption page, the user adds their message to the plaintext box and then adds their password to the password field. when they press enter, the program will open a new window and will present the user with their final encrypted message.
it is up to the user what they wish to do with the encrypted cipher text (store it, share it, etc.)

2. Decrypting Text.
to decrypt text, the user has to follow this path to go to the decrypting plaintext window: Home Page --> Decrypt --> Plain Text. 
once in the plain text Decryption page, the user will place their cipher text to the cipher text box and then adds their password to the password field. when they press enter, the program will open a new window and will present the user with their final decrypted message.

3. Encrypting a Text File.
to encrypt a text file, the user has to follow this path to go to the encrypting text file window: Home Page --> Encrypt --> Text File. 
once in the window, the user will be presented with two input fields. the top field is where the user will specify the text file they want to encrypt, which they will do by adding the path to their text file. the user can also press the button to the left of the field to open up a file explorer page, where they can look for the text document themselves. in the password field, the user will be able to create a password. when the user presses submit, the program will open up a new window informing the user that their file finished encrypting. if the user opens up the text file, then they will see the encrypted words on the file.

4. Decrypting a Text File.
to decrypt a text file, the user has to follow this path to go to the decrypting text file window: Home Page --> Decrypt --> Text File. 
once in the window, the user will be presented with two input fields. the top field is where the user will specify the text file they want to decrypt, which they will do by adding the path to their text file. the user can also press the button to the left of the field to open up a file explorer page, where they can look for the text document themselves. in the password field, the user will be able to enter the password used to encrypt the text file. once the user presses submit, the program will open up a new window informing the user that their file finished decrypting. if the user opens up the text file, then they will see the original plain text in their text file once more.

5. Encrypting an Image.
to encrypt an image, the user has to follow this path to go to the encrypting image window: Home Page --> Encrypt --> Image File. 

The input for image encryption will be the image file that the user wants encrypted, and the output will be a text file that contains the encrypted data of the image.

Once in the window, the user will be presented with 3 input fields. the top field is where the user will place the image that they want encrypted, which they will do by adding the path to their image file. the user can also press the button to the left of the field to open up a file explorer page, where they can look for the image file themselves. the middle field is where the user will create a password that will be required for decrypting the file. the bottom field is the file location field, there the user will specify where they want to store the text file that will contain the encrypted bytes. the user will give this file a name of their choosing. 

IMPORTANT: it is vital that the user specifies that the output is a text document by adding .txt to the end of the name of the output. failure to do so will result in the encrypted data being inaccessible and the data potentially being lost, with decryption of the bytes back to the original image being impossible.

once the user hits submit, a new window will pop up telling the user where the text file containing their encrypted bytes is located in their computer.
it is up to the user what they wish to do with the text file containing the encrypted bytes (store it, share it, etc.)
NOTE: a copy of the encrypted bytes should also be able to be decrypted, the original file is not required.

6. Decrypting an Image.
to decrypt an image, the user has to follow this path to go to the decrypting image window: Home Page --> Decrypt --> Image File. 

The input for image Decryption will be the text file that contains the encrypted bytes produced by the image Encryption page, and the output will be the original image in its original format.

Once in the window, the user will be presented with 3 input fields. the top field is where the user will place the text file containing the encrypted image bytes that they want decrypted, which they will do by adding the path to the text file. the user can also press the button to the left of the field to open up a file explorer page, where they can look for the text file themselves. the middle field is where the user will enter the password that was used to encrypt the image. the bottom field is the file location field, there the user will specify where they want to store the decrypted image file. the user will give this file a name of their choosing. 

IMPORTANT: it is vital that the user specifies the image format by adding whatever format the original image was in to the end of the given name. For example, if the original image was a jpg file, then the user must add .jpg to the end of the name that they will give to the image file. failure to do so will result in the decrypted image being inaccessible due to being in the wrong format, and the contents of the image potentially being lost.

once the user hits submit, a new window will pop up telling the user where the decrypted image file is located in their computer.

NOTE ABOUT IMAGE FORMATS: I have been able to text and verify that the image encryption and decryption works on the following image formats:
.jpg files, .png files.
it is possible that the image encryption algorithm works on other formats, but these are the only ones that I have been able to verify.

7. Encryption of Other File Types.
to encrypt a file, the user has to follow this path to go to the encrypting other file type window: Home Page --> Encrypt --> Other File Types.

The input for other file encryption will be the file that the user wants encrypted, and the output will be a text file that contains the encrypted data of the original file.

Once in the window, the user will be presented with 3 input fields. the top field is where the user will place the file that they want encrypted, which they will do by adding the path to their file. the user can also press the button to the left of the field to open up a file explorer page, where they can look for the file themselves. the middle field is where the user will create a password that will be required for decrypting the file. the bottom field is the file location field, there the user will specify where they want to store the text file that will contain the encrypted bytes. the user will give this file a name of their choosing.

IMPORTANT: it is vital that the user specifies that the output is a text document by adding .txt to the end of the name of the output. failure to do so will result in the encrypted data being inaccessible and the data potentially being lost, with decryption of the bytes back to the file being impossible.

Once the user hits submit, a new window will pop up telling the user where the text file containing their encrypted bytes is located in their computer.
it is up to the user what they wish to do with the text file containing the encrypted bytes (store it, share it, etc.)
NOTE: a copy of the encrypted bytes should also be able to be decrypted, the original file is not required.

8. Decryption of Other File Types.
to decrypt a file, the user has to follow this path to go to the decrypting other file type window: Home Page --> Decrypt --> Other File Types. 

The input for image Decryption will be the text file that contains the encrypted bytes produced by the Other File Types Encryption page, and the output will be the original file in its original format.

Once in the window, the user will be presented with 3 input fields. the top field is where the user will place the text file containing the encrypted file bytes that they want decrypted, which they will do by adding the path to the text file. the user can also press the button to the left of the field to open up a file explorer page, where they can look for the text file themselves. the middle field is where the user will enter the password that was used to encrypt the file. the bottom field is the file location field, there the user will specify where they want to store the decrypted file. the user will give this file a name of their choosing. 

IMPORTANT: it is vital that the user specifies the file format by adding whatever format the original image was in to the end of the given name. For example, if the original image was an mp4 video file, then the user must add .mp4 to the end of the name that they will give to the decrypted file. failure to do so will result in the decrypted file being inaccessible due to being in the wrong format, and the contents of the file potentially being lost.

Once the user hits submit, a new window will pop up telling the user where the decrypted file is located in their computer.

NOTE ABOUT FILE FORMATS: I have been able to text and verify that the file types that the Other File Types encryption and decryption page works on includes the following:
.mp4 files, .mp3 files, .pdf files.
it is possible that the file encryption algorithm works on other formats, but these are the only ones that I have been able to verify.