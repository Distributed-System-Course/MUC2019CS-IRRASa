# Generated by Django 3.2.9 on 2021-11-18 01:20

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='House',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('source_prompt', models.CharField(max_length=200, verbose_name='提示来源')),
                ('house_name', models.CharField(max_length=200, verbose_name='房屋名称')),
                ('house_area', models.IntegerField(verbose_name='房屋面积')),
                ('house_price', models.IntegerField(verbose_name='租价')),
                ('house_type', models.CharField(max_length=200, verbose_name='房型')),
                ('house_location', models.CharField(max_length=200, verbose_name='位置')),
            ],
        ),
    ]
