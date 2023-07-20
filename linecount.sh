#!/bin/bash
cd src
cd org
find . -name '*.java' | xargs wc -l
find . -name '*.glsl' | xargs wc -l
