#!/bin/python3

from setuptools import setup

setup(name='acctk',
      version='0.1',
      # list folders, not files
      #packages=['acctk',
      #          'acctk.test'],
      scripts=['acctk/bin/addacc'],
      package_data={'acctk': ['data/acc_table.txt']},
      )
