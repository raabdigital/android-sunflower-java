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

import com.google.samples.apps.sunflower.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower.data.PlantRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Shawn Wang on 3/27/19.
 */
public class PlantDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private String plantId;
    private PlantRepository plantRepository;
    private GardenPlantingRepository gardenPlantingRepository;

    public PlantDetailViewModelFactory(PlantRepository plantRepository,
                                       GardenPlantingRepository gardenPlantingRepository,
                                       String plantId) {
        this.plantId = plantId;
        this.plantRepository = plantRepository;
        this.gardenPlantingRepository = gardenPlantingRepository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlantDetailViewModel(plantRepository, gardenPlantingRepository, plantId);
    }
}
