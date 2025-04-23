
The generator requires to be run on a Java 21 runtime (or newer).

## Verify Signing

The artifacts built in this project are signed with this [signature](http://keyserver.ubuntu.com/pks/lookup?search=0xF9B879EDFC0AB297588936F49CCE5D89C917DBD4&fingerprint=on&op=index).

If you download the cli-jar release, please verify its signature before you use it:

```console
$ gpg --keyserver keyserver.ubuntu.com --recv-keys F9B879EDFC0AB297588936F49CCE5D89C917DBD4
gpg: key 9CCE5D89C917DBD4: public key "Jesper Skov (mada.dk signing key) <jskov@mada.dk>" imported
gpg: Total number processed: 1
gpg:               imported: 1

$ gpg --verify generator-cli-VERSION-cli.jar.asc generator-cli-VERSION-cli.jar
gpg: Signature made Sat 26 Feb 2022 04:45:58 PM CET
gpg:                using RSA key 1A5363B73D8463A8C7B63D199FCC46FEABE97157
gpg: Good signature from "Jesper Skov (mada.dk signing key) <jskov@mada.dk>" [unknown]
gpg: WARNING: This key is not certified with a trusted signature!
gpg:          There is no indication that the signature belongs to the owner.
Primary key fingerprint: F9B8 79ED FC0A B297 5889  36F4 9CCE 5D89 C917 DBD4
     Subkey fingerprint: 1A53 63B7 3D84 63A8 C7B6  3D19 9FCC 46FE ABE9 7157
```

