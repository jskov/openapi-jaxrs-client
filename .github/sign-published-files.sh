#!/bin/bash

if [[ $# != 3 ]]; then
    echo "Usage:"
    echo " sign-publish-files dir version keyId"
    echo "  dir:     the directory to look for files in"
    echo "  version: the version of files to look for"
    echo "  keyId:   the GPG key id"
    exit 1
fi

d=$1
version=$2
keyId=$3

set +x

echo Sign files in $d for version $version with $keyId

# Prepare gpg
export GNUPGHOME=~/.gnupg
mkdir -p $GNUPGHOME
chmod og-rwx $GNUPGHOME

# Cleanup at exit
function onexit() {
  rm -rf ~/.gnupg
}
trap onexit EXIT

# Import private key and make it ultimately trusted
export GPG_TTY=$(tty)
echo $MADA_SIGNING_KEY | sed 's/\\n/\n/g;' > $GNUPGHOME/s
echo $MADA_SIGNING_PASSWORD | gpg --import --batch --pinentry-mode loopback $GNUPGHOME/s >/dev/null 2>&1
echo -e "5\ny\n" |  gpg --batch --command-fd 0 --expert --edit-key $keyId trust 2>/dev/null

# Sign relevant files
for f in $(find $d -name \*$version\*.pom -o -name \*$version\*.module -o -name \*$version\*.jar); do
    echo " - $f"
    echo $MADA_SIGNING_PASSWORD | gpg --quiet --batch --yes --pinentry-mode loopback --passphrase-fd 0 -u $keyId --detach-sign --armor "$f"
done

exit 0
