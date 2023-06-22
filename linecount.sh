#!/bin/bash

find . -name '*.java' | xargs wc -l
find . -name '*.glsl' | xargs wc -l
