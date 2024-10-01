#!/usr/bin/env bash
cd "$1" || exit
for file in ./*; do 
    newfile=$(echo "${file/_/' '}" | awk '{print $1 "-" $2}')
    mv "$file" "$newfile"
done
echo "done"
