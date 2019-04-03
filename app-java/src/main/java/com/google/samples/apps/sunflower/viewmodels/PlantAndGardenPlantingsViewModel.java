/*
 * Copyright 2019 Shawn Wang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.viewmodels;

import com.google.common.base.Preconditions;
import com.google.samples.apps.sunflower.data.GardenPlanting;
import com.google.samples.apps.sunflower.data.Plant;
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;


/**
 * Created by Shawn Wang on 3/26/19.
 */
public class PlantAndGardenPlantingsViewModel extends ViewModel {
    public ObservableField<String> waterDateString;
    public ObservableInt wateringInterval;
    public ObservableField<String> imageUrl;
    public ObservableField<String> plantName;
    public ObservableField<String> plantDateString;

    public PlantAndGardenPlantingsViewModel(@NonNull PlantAndGardenPlantings plantings) {
        final Plant plant = Preconditions.checkNotNull(plantings.getPlant());
        final GardenPlanting gardenPlanting = plantings.getGardenPlantings().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.US);

        this.waterDateString = new ObservableField<>(dateFormat.format(gardenPlanting.getLastWateringDate().getTime()));
        this.wateringInterval = new ObservableInt(plant.getWateringInterval());
        this.imageUrl = new ObservableField<>(plant.getImageUrl());
        this.plantName = new ObservableField<>(plant.getName());
        this.plantDateString = new ObservableField<>(dateFormat.format(gardenPlanting.getPlantDate().getTime()));
    }
}
