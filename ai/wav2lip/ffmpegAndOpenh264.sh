#!/bin/bash

apt-get update --fix-missing
conda remove --force ffmpeg
conda install ffmpeg=4.2.2
conda install openh264=2.1.0