#!/usr/bin/env python

from setuptools import setup

setup(name='capitalize',
      version='1.0',
      # list folders, not files
      packages=['capitalize',
                'capitalize.test'],
      scripts=['capitalize/bin/capitalize'],
      package_data={'capitalize': ['data/cap_data.txt']},
      )
